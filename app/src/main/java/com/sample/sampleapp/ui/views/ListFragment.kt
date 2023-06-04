package com.sample.sampleapp.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import com.sample.sampleapp.R
import com.sample.sampleapp.data.model.CharacterResponse
import com.sample.sampleapp.data.model.NetworkResult
import com.sample.sampleapp.databinding.FragmentListBinding
import com.sample.sampleapp.ui.viewmodel.MainViewModel
import com.sample.sampleapp.ui.views.adapter.CharacterAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ListFragment : Fragment(), MenuProvider {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var characterList: List<CharacterResponse.RelatedTopic?>
    private lateinit var adapter: CharacterAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentListBinding.inflate(inflater, container, false)
        val callback = requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            binding.slidingPaneLayout.closePane()
        }
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)
        adapter = CharacterAdapter(){
            viewModel.characterDetails.postValue(it)
            binding.slidingPaneLayout.open()
        }
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            viewModel.characters.observe(viewLifecycleOwner) {
                progressBar.isVisible = it is NetworkResult.Loading
                when(it) {
                    is NetworkResult.Loading -> {
                        progressBar.isVisible = true
                    }
                    is NetworkResult.Error -> {
                        Toast.makeText(requireContext(), it.msg, Toast.LENGTH_LONG).show()
                    }
                    is NetworkResult.Success -> {
                        characterList = it.data.relatedTopics
                        rvCharacterNames.adapter = adapter
                        renderList(characterList)
                    }

                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun renderList(list: List<CharacterResponse.RelatedTopic?>){
        adapter.addData(list as List<CharacterResponse.RelatedTopic>)
        adapter.notifyDataSetChanged()
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.search_menu, menu)

    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        menuItem.setOnActionExpandListener(object : MenuItem.OnActionExpandListener {
            override fun onMenuItemActionExpand(item: MenuItem): Boolean {
                return true
            }

            override fun onMenuItemActionCollapse(item: MenuItem): Boolean {
                renderList(characterList)
                return true
            }
        })
        return true
    }

    override fun onPrepareMenu(menu: Menu) {
        val searchItem = menu.findItem(R.id.actionSearch)
        val searchView = searchItem.actionView as SearchView
        search(searchView)
        super.onPrepareMenu(menu)
    }

    private fun search(search: SearchView) {
        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                adapter.filter.filter(query)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return true
            }
        })
    }

}