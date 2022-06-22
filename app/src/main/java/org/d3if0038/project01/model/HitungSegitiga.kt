package org.d3if0038.project01.model

import org.d3if0038.project01.db.SegitigaEntity

fun SegitigaEntity.hitungSegitiga(): Hasil {
    val hasil = alas * tinggi / 2

    return Hasil(hasil)
}