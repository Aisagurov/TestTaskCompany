package suvorov.testtaskcompany.presentation.ui.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import suvorov.testtaskcompany.databinding.FragmentListBinding
import suvorov.testtaskcompany.presentation.ui.base.BaseFragment
import suvorov.testtaskcompany.presentation.ui.list.adapter.ListAdapter
import suvorov.testtaskcompany.presentation.ui.list.adapter.clicklistener.ItemClickListener

@AndroidEntryPoint
class ListFragment:
    BaseFragment<FragmentListBinding>(FragmentListBinding::inflate),
    ItemClickListener
{
    private val viewModel: ListViewModel by viewModels()
    private val listAdapter = ListAdapter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
        initView()
        viewModel.getCompaniesListFromApi()
    }

    private fun observeViewModel() {
        viewModel.companiesListFromDatabase.observe(viewLifecycleOwner) {
            listAdapter.updateList(it)
        }

        viewModel.isLoading.observe(viewLifecycleOwner) {
            binding.progressBar.visibility =
                if(viewModel.isListEmpty() && it) View.VISIBLE else View.GONE
        }
    }

    private fun initView() {
        binding.listRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = listAdapter
        }
    }

    override fun onItemClick(id: String) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(id))
    }
}