package suvorov.testtaskcompany.presentation.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import suvorov.testtaskcompany.domain.ListRepository
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val repository: ListRepository): ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    val companiesListFromDatabase = repository.companiesListFromDatabase

    fun isListEmpty(): Boolean {
        return companiesListFromDatabase.value?.isEmpty() ?: true
    }

    fun getCompaniesListFromApi() {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.postValue(true)
            kotlin.runCatching {
                repository.getCompaniesListFromApi()
            }.onSuccess {
                _isLoading.postValue(false)
            }
        }
    }
}