/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.GetCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;


public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    ParseObject pontuacao = new ParseObject("Pontuacao");
    pontuacao.put("nome","Joao");
    pontuacao.put("pontos",17);
    pontuacao.saveInBackground(new SaveCallback() {
      @Override
      public void done(ParseException e) {
        if(e == null){
          Log.i("salvarPontos", "Dados salvos!");
        }else{
          Log.i("salvarPontos", "Erro ao salvar dados!");

        }
      }
    });
    ParseUser.enableAutomaticUser();

    /*
    ParseQuery<ParseObject> consulta = ParseQuery.getQuery("Pontuacao");
    consulta.getInBackground("gaqki4IsE9", new GetCallback<ParseObject>() {
      @Override
      public void done(ParseObject object, ParseException e) {
        if( e == null){
          object.put("pontos",100000);
          object.saveInBackground();
        }else {
          Log.i("consultaObjeto", "Erro ao consultar objeto!");
        }
      }
    });*/
  }


}
