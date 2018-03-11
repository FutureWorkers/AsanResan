package com.example.distribution.p007

import java.io.Serializable

/**
 * Created by Z50 on 2018-02-18.
 */

class CompanyDetail : Serializable {

    var companyName: String? = null
    var companyAddress: String? = null
    var companyId: Int = 0

    constructor()
    constructor(companyName: String, companyAddress: String, companyId: Int) {
        this.companyName = companyName
        this.companyAddress = companyAddress
        this.companyId = companyId
    }
}
