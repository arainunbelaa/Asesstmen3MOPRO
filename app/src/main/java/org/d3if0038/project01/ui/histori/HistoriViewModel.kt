package org.d3if0038.project01.ui.histori

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if0038.project01.db.SegitigaDao

class HistoriViewModel(private val db: SegitigaDao) : ViewModel() {
    val data = db.getLastSegitiga()
    fun hapusData() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            db.clearData()
        }
    }
}