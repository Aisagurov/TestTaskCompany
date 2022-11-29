package suvorov.testtaskcompany.presentation.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import suvorov.testtaskcompany.data.model.local.DetailEntity
import suvorov.testtaskcompany.databinding.FragmentDetailBinding
import suvorov.testtaskcompany.presentation.ui.base.BaseFragment
import suvorov.testtaskcompany.util.loadImage

@AndroidEntryPoint
class DetailFragment: BaseFragment<FragmentDetailBinding>(FragmentDetailBinding::inflate) {

    private val viewModel: DetailViewModel by viewModels()
    private val args: DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val detailId = args.id
        observeViewModel(detailId)
        viewModel.getDetailFromApi(detailId.toInt())
        initClickListener()
    }

    private fun observeViewModel(detailId: String) {
        viewModel.detailById(detailId).observe(viewLifecycleOwner) { detail ->
            detail?.let {
                initView(it)
            }
        }
    }

    private fun initView(model: DetailEntity) {
        binding.apply {
            imageView.loadImage(model.img)
            nameTextView.text = model.name
            descriptionTextView.text = model.description
            webTextView.text = model.www
            phoneTextView.text = model.phone
            latTextView.text = model.lat.toString()
            lonTextView.text = model.lon.toString()
        }
    }

    private fun initClickListener() {
        binding.toolbar.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}