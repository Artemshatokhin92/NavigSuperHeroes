package com.shatokhin.navigsuperheroes.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.shatokhin.navigsuperheroes.R
import com.shatokhin.navigsuperheroes.data.models.SuperHeroJson
import com.squareup.picasso.Picasso

class AdapterRvSuperHeroes(private val clickListenerSuperHero: ClickListenerSuperHero): ListAdapter<SuperHeroJson, AdapterRvSuperHeroes.ViewHolderHero>(SuperHeroesDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderHero {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_super_hero, parent, false)
        return ViewHolderHero(view, clickListenerSuperHero)
    }

    override fun onBindViewHolder(holder: ViewHolderHero, position: Int) {
        holder.bind( getItem(position) )
    }

    class ViewHolderHero(itemView: View, private val clickListenerSuperHero: ClickListenerSuperHero): RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.ivImage)
        val name = itemView.findViewById<TextView>(R.id.tvName)

        fun bind(hero: SuperHeroJson){
            Picasso.get()
                .load(hero.image.url)
                .into(image)

            name.text = hero.name

            itemView.setOnClickListener {
                clickListenerSuperHero.clickHero(hero)
            }
        }

    }
    interface ClickListenerSuperHero{
        fun clickHero(hero: SuperHeroJson)
    }

}

object SuperHeroesDiffCallback : DiffUtil.ItemCallback<SuperHeroJson>() {
    override fun areItemsTheSame(oldItem: SuperHeroJson, newItem: SuperHeroJson): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: SuperHeroJson, newItem: SuperHeroJson): Boolean {
        return oldItem == newItem
    }
}