package com.cursoandroid.testandofirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    /*implementando função para realizar a inserção e manuseio dos dados no FireBase*/
    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
    private FirebaseAuth usuario = FirebaseAuth.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DatabaseReference usuarios = referencia.child("usuarios");


        /*Filtrando usuários*/
        //DatabaseReference usuarioPesquisa = usuarios.child("-Mve6JNzxPyO2q9SLmWD");
        //Query usuarioPesquisa = usuarios.orderByChild("nome").equalTo("Giovane");
                /*filtro para buscar apenas os primeiros e últimos da lista*/
        //Query usuarioPesquisa = usuarios.orderByKey().limitToFirst(2);
        //Query usuarioPesquisa = usuarios.orderByKey().limitToLast(2);
                /*Filtro para buscar dados a partir de determinada informação (maior ou igual)*/
       // Query usuarioPesquisa = usuarios.orderByChild("idade").startAt(40);
       // Query usuarioPesquisa = usuarios.orderByChild("idade").endAt(22);


                /*Entre dois valores*/
        //Query usuarioPesquisa = usuarios.orderByChild("idade").startAt(18).endAt(30);


                /*Filtrar por palavras*/
        Query usuarioPesquisa = usuarios.orderByChild("nome").startAt("G").endAt("G" + "\uf8ff");



        usuarioPesquisa.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               //Usuario dadosUsuario = snapshot.getValue(Usuario.class);
              //  Log.i("Dados usuario", "Nome: " + dadosUsuario.getNome() + ". Idade: " + dadosUsuario.getIdade());
                Log.i("Dados Usuários", snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


       /* Usuario usuario = new Usuario();
        usuario.setNome("Rodrigo");
        usuario.setSobrenome("Matos");
        usuario.setIdade(35);

        usuarios.push().setValue( usuario );*/


        /*Deslogar usuario

        usuario.signOut();*/

        /*Logar usuario
        usuario.signInWithEmailAndPassword("giio.santana@gmail.com", "123456").addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Log.i("SignIn", "Sucesso ao logar usuário!");
                }else{
                    Log.i("SignIn", "Erro ao logar usuário!");
                }
            }
        });*/


        /*Verifica usuario logado

        if (usuario.getCurrentUser() != null){
            Log.i("CurrentUser", "Usuário logado!!");
        }else{
            Log.i("CurrentUser", "Usuário não logado!!");
        }*/

        /*Cadastrando usuario
        usuario.createUserWithEmailAndPassword("giio2.santana@gmail.com", "123456").addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Log.i("CreateUser", "Sucesso ao cadastrar usuário!");
                }else{
                    Log.i("CreateUser", "Erro ao cadastrar usuário!");
                }
            }
        });*/




        /*DatabaseReference usuarios =  referencia.child("usuarios").child("001");
        DatabaseReference produtos = referencia.child("produtos");

        usuarios.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                Log.i("FIREBASE", snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        Usuario usuario = new Usuario();
        usuario.setNome("Leticia");
        usuario.setSobrenome("Palmieri");
        usuario.setIdade(26);

        usuarios.child("002").setValue( usuario );

        Produtos produto = new Produtos();
        produto.setDescricao("Bebidas");
        produto.setMarca("Coca-Cola");
        produto.setPreco(3.50);

        produtos.child("001").setValue( produto );*/
    }
}