package com.example.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Contacto extends AppCompatActivity {
    EditText nombres ;
    EditText correo ;
    EditText descripcion ;
    Button btnSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        /* CODIGO PARA DECLARAR EL TOOLBAR */
        Toolbar ActionBar = (Toolbar) findViewById(R.id.ActionBar);
        setSupportActionBar(ActionBar);
        //ActionBar.setNavigationIcon(R.attr.homeAsUpIndicator);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        // variables
        nombres =  (EditText) findViewById(R.id.nombres);
        correo = (EditText) findViewById(R.id.correo);
        descripcion = (EditText) findViewById(R.id.descripcion);
        btnSend= (Button) findViewById(R.id.button);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Properties properties = new Properties();
                properties.put("mail.smtp.auth","true");
                properties.put("mail.smtp.starttls.enable","true");
                properties.put("mail.smtp.host","smtp.gmail.com");
                properties.put("mail.smtp.port","587");

                Session session = Session.getInstance(properties, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(Config.EMAIL,Config.PASSWORD);
                    }
                });


                try {
                    Message message= new MimeMessage(session);
                    message.setFrom(new InternetAddress(Config.EMAIL));
                    message.setRecipients(Message.RecipientType.TO,
                            InternetAddress.parse(correo.getText().toString().trim()));

                    message.setSubject(nombres.getText().toString().trim());
                    message.setText(descripcion.getText().toString().trim());


                    new SendMail().execute(message);

                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
        });



            //Toast.makeText(getApplicationContext(), (fecha.getYear()), Toast.LENGTH_SHORT).show();
            // Log.e("la fecha", ":");













    }


    private class SendMail extends AsyncTask<Message,String,String> {

        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(Contacto.this,"Espere","Enviando Correo", true,false);

        }

        @Override
        protected String doInBackground(Message... messages) {

            try {
                Transport.send(messages[0]);
                return "Satisfactorio";


            } catch (MessagingException e) {
                e.printStackTrace();
                return "Error";
            }



        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

                progressDialog.dismiss();
                if(s.equals("Satisfactorio")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(Contacto.this);
                    builder.setCancelable(false);
                    builder.setTitle(Html.fromHtml("<font color='#509324'>Satisfactorio</font>"));
                    builder.setMessage("Email enviado Satisfactoriamente");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();

                            nombres.setText("");
                            correo.setText("");
                            descripcion.setText("");
                        }
                    });
                    builder.show();

                } else {

                    Toast.makeText(getApplicationContext(),"Algo malo paso ?",Toast.LENGTH_LONG).show();

                }

        }
    }
}