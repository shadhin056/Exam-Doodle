package com.example.konamoniruzzaman.expand;

import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.konamoniruzzaman.R;
import com.example.konamoniruzzaman.multicheck.Genre;
import com.example.konamoniruzzaman.multicheck.MultiCheckGenre;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

public class GenreViewHolder extends GroupViewHolder {

  private TextView genreName;
  private ImageView arrow;
  private ImageView icon;

  public GenreViewHolder(View itemView) {
    super(itemView);
    genreName = (TextView) itemView.findViewById(R.id.list_item_genre_name);
    arrow = (ImageView) itemView.findViewById(R.id.list_item_genre_arrow);
    icon = (ImageView) itemView.findViewById(R.id.list_item_genre_icon);
  }

  public void setGenreTitle(ExpandableGroup genre) {
    if (genre instanceof Genre) {
      genreName.setText(genre.getTitle());
      icon.setBackgroundResource(((Genre) genre).getIconResId());
    }
    if (genre instanceof MultiCheckGenre) {
      genreName.setText(genre.getTitle());
      icon.setBackgroundResource(((MultiCheckGenre) genre).getIconResId());
    }

  }

  @Override
  public void expand() {
    animateExpand();
  }

  @Override
  public void collapse() {
    animateCollapse();
  }

  private void animateExpand() {
    RotateAnimation rotate =
        new RotateAnimation(360, 90, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
    rotate.setDuration(300);
    rotate.setFillAfter(true);
    arrow.setAnimation(rotate);
  }

  private void animateCollapse() {
    RotateAnimation rotate =
        new RotateAnimation(90, 360, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
    rotate.setDuration(300);
    rotate.setFillAfter(true);
    arrow.setAnimation(rotate);
  }
}
