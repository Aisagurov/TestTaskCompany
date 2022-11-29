package suvorov.testtaskcompany.presentation.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import suvorov.testtaskcompany.domain.DetailRepository
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: DetailRepository): ViewModel() {

    fun detailById(id: String) = repository.detailById(id)

    fun getDetailFromApi(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                repository.getDetailFromApi(id)
            }
        }
    }
}