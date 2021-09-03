package com.example.examenfinal.holder;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.examenfinal.PubsActivity;
import com.example.examenfinal.R;
import com.example.examenfinal.models.Volumen;
import com.mindorks.placeholderview.PlaceHolderView;
import com.mindorks.placeholderview.annotations.Animate;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

@Animate(Animate.CARD_TOP_IN_ASC)
@NonReusable
@Layout(R.layout.listapubs)
public class HolderPubs{
    Volumen pubsList;

    private Context context;
    @View(R.id.pubsHolder)
    PlaceHolderView pubsHolder;

    @View(R.id.txtSeccion)
    TextView txtSeccion;
    @View(R.id.txtTitle)
    TextView txtTitle;
    @View(R.id.txtDOI)
    TextView txtDOI;



    public HolderPubs(Context context, Volumen pubs) {
        this.pubsList = pubs;
        this.context = context;
    }
    @Resolve
    public void onResolved() {
        this.txtSeccion.setText(pubsList.getSection());
        this.txtTitle.setText(pubsList.getTitle());
        this.txtDOI.setText(Html.fromHtml(pubsList.getDoi()));

        txtDOI.setClickable(true);
        txtDOI.setMovementMethod(LinkMovementMethod.getInstance());
        txtDOI.setText(Html.fromHtml("<a  href=\"" + pubsList.getDoi() + "\">" + pubsList.getDoi() + "</a>"));
       /* txtDOI.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Uri enlace = Uri.parse(pubsList.getDoi());
                Intent in = new Intent(Intent.ACTION_VIEW);
                in.setData(enlace);
                context.startActivity(in);
            }
        });*/


    }
}
