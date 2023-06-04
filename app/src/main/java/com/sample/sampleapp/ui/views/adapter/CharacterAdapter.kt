package com.sample.sampleapp.ui.views.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sample.sampleapp.data.model.CharacterResponse
import com.sample.sampleapp.databinding.CharacterItemBinding
import com.sample.sampleapp.utility.getName
import java.util.Locale

class CharacterAdapter(
    var itemClicked: (CharacterResponse.RelatedTopic) -> Unit
) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>(), Filterable {

    private var characters = emptyList<CharacterResponse.RelatedTopic>()
    private var unfiltered = emptyList<CharacterResponse.RelatedTopic>()
    private var filteredCharacters = emptyList<CharacterResponse.RelatedTopic>()

    fun filterList(filterList: List<CharacterResponse.RelatedTopic>) {
        characters = filterList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CharacterViewHolder {
        val biding = CharacterItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CharacterViewHolder(biding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = getName(characters[position].firstURL)
        holder.bind(character)
        holder.itemView.setOnClickListener {
            characters[position].let { item ->
                itemClicked.invoke(item)
            }
        }
    }

    override fun getItemCount() = characters.size


    class CharacterViewHolder(private val binding: CharacterItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(name: String) {
            binding.tvCharacterName.text = name
        }
    }

    fun addData(list: List<CharacterResponse.RelatedTopic>) {
        characters = list
        unfiltered = characters
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charString = constraint?.toString()?.lowercase() ?: ""
                if (charString.isEmpty()) filteredCharacters = characters else {
                    val filteredList = emptyList<CharacterResponse.RelatedTopic>().toMutableList()
                    characters
                        .filter {
                            (getName(it.firstURL).lowercase(locale = Locale.getDefault()).contains(charString))
                            it.text.lowercase().contains(charString)
                        }
                        .forEach { filteredList += it }
                    filteredCharacters = filteredList

                }
                return FilterResults().apply { values = filteredCharacters }
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {

                filteredCharacters = if (results?.values == null)
                    emptyList()
                else
                    results.values as List<CharacterResponse.RelatedTopic>
                filterList(filteredCharacters)
            }
        }
    }

    companion object {
        private val DiffCallback = object: DiffUtil.ItemCallback<CharacterResponse.RelatedTopic>() {
            override fun areItemsTheSame(oldItem: CharacterResponse.RelatedTopic, newItem: CharacterResponse.RelatedTopic): Boolean {
                return oldItem.firstURL == newItem.firstURL
            }

            override fun areContentsTheSame(oldItem: CharacterResponse.RelatedTopic, newItem: CharacterResponse.RelatedTopic): Boolean {
                return oldItem==newItem
            }
        }
    }
}