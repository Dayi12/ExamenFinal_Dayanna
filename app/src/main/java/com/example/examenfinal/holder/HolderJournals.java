package com.example.examenfinal.holder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.examenfinal.IssuesActivity;
import com.example.examenfinal.R;
import com.example.examenfinal.models.Journals;
import com.mindorks.placeholderview.PlaceHolderView;
import com.mindorks.placeholderview.annotations.Animate;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

@Animate(Animate.CARD_TOP_IN_ASC)
@NonReusable
@Layout(R.layout.listajournals)
public class HolderJournals {

    Journals journalsList = new Journals();
    private Context context;
    @View(R.id.recycler)
    PlaceHolderView recycler;
    @View(R.id.imgfoto)
    ImageView imgfoto;
    @View(R.id.txtNombrerevista)
    TextView txtNombrerevista;
    @View(R.id.txtDescripcion)
    TextView txtDescripcion;
    @View(R.id.txtDoi)
    TextView txtDoi;

    @Click(R.id.journals)
    public void Click() {
        Intent intent = new Intent(context, IssuesActivity.class);
        Bundle b = new Bundle();
        b.putString("j_id", journalsList.getJournal_id());
        intent.putExtras(b);
        context.startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }
    public HolderJournals(Context context, Journals revistas) {
        this.journalsList = revistas;
        this.context = context;
    }
    @Resolve
    public void onResolved() {
        this.txtNombrerevista.setText(journalsList.getName());
        this.txtDescripcion.setText(Html.fromHtml(journalsList.getDescription()));
        Glide.with(context).load(journalsList.getPortada()).into(imgfoto);

    }

}

