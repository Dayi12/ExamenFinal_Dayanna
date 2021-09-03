package com.example.examenfinal.holder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.examenfinal.IssuesActivity;
import com.example.examenfinal.PubsActivity;
import com.example.examenfinal.R;
import com.example.examenfinal.models.Issues;
import com.mindorks.placeholderview.PlaceHolderView;
import com.mindorks.placeholderview.annotations.Animate;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

@Animate(Animate.CARD_TOP_IN_ASC)
@NonReusable
@Layout(R.layout.listaissues)
public class HolderIssues {
    Issues issuesList;
    private Context context;
    @View(R.id.issuesHolder)
    PlaceHolderView issuesHolder;
    @View(R.id.imgfoto1)
    ImageView imgfoto1;
    @View(R.id.txtTitulo)
    TextView txtTitulo;
    @View(R.id.txtAnio)
    TextView txtAnio;
    @View(R.id.txtDoi)
    TextView txtDoi;

    @Click(R.id.liPrincipal)
    public void Click() {
        Intent intent = new Intent(context, PubsActivity.class);
        Bundle b = new Bundle();
        b.putString("i_id", issuesList.getIssue_id());
        intent.putExtras(b);
        context.startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }
    public HolderIssues(Context context, Issues issues) {
        this.issuesList = issues;
        this.context = context;
    }
    @Resolve
    public void onResolved() {
        this.txtTitulo.setText(issuesList.getTitle());
        this.txtAnio.setText(issuesList.getDate_published());
        txtDoi.setText(Html.fromHtml("<a  href=\"" + issuesList.getDoi() + "\">" + issuesList.getDoi() + "</a>"));
        Glide.with(context).load(issuesList.getCover()).into(imgfoto1);
    }

}

