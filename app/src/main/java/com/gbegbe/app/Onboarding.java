package com.gbegbe.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;

import com.gbegbe.app.app_data.HomeActivity;
import com.ramotion.paperonboarding.PaperOnboardingFragment;
import com.ramotion.paperonboarding.PaperOnboardingPage;

import java.util.ArrayList;

public class Onboarding extends AppCompatActivity {

    float x1,x2,y1,y2;

    private FragmentManager fragmentManager;


    public boolean onTouchEvent(MotionEvent touchEvent){
        switch(touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();
                if(x1 < x2){
                Intent i = new Intent(Onboarding.this, HomeActivity.class);
                startActivity(i);
            }else if(x1 > x2){
                Intent i = new Intent(Onboarding.this, HomeActivity.class);
                startActivity(i);
            }
            break;
        }
        return false;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        fragmentManager = getSupportFragmentManager();

        final PaperOnboardingFragment paperOnboardingFragment = PaperOnboardingFragment.newInstance(getDataForOnBoarding());

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, paperOnboardingFragment);
        fragmentTransaction.commit();

    }

    private ArrayList<PaperOnboardingPage> getDataForOnBoarding() {

        PaperOnboardingPage src1 = new PaperOnboardingPage("Comunique facilmente", "O Gbégbè é um aplicativo pensado e desenvolvido por pessoas que já enfrentaram barreiras de comunicação linguisticas. Já pensou traduzir instantaneamente uma palavra, uma frase, um texto, uma imagem ou até sua propria fala? AGORA VOCÊ PODE", Color.parseColor("#ff5636"), R.drawable.onboard1, R.drawable.ic_logo);
        PaperOnboardingPage src2 = new PaperOnboardingPage("Aplicativo inclusivo", "O Gbégbè é inclusivo pois permite e facilita uma comunicação entre e com pessoeas surdas e mudas. Isso permite que mesmo quem não saiba libras consiga se comunicar", Color.parseColor("#ff5636"), R.drawable.onboard2, R.drawable.ic_logo);
        PaperOnboardingPage src3 = new PaperOnboardingPage("Noticias, cursos e bancos de dados", "O aplicativo integra notícias, um curso de libras gratis e os maiores bancos de dados e dicionarios em linguas indigenas", Color.parseColor("#ff5636"), R.drawable.onboard3, R.drawable.ic_logo);

    ArrayList<PaperOnboardingPage> elements = new ArrayList<>();
    elements.add(src1);
    elements.add(src2);
    elements.add(src3);
    return elements;





    }
}