package com.onegravity.accountservice.route.request

import com.onegravity.accountservice.persistence.model.account.AccountStatus
import com.onegravity.accountservice.persistence.model.customer.CustomerStatus
import com.onegravity.accountservice.persistence.model.customer.Language

val accountExampleRequest = RequestAccount(status = AccountStatus.Active)

val customerExampleRequest = RequestCustomer(
    status = CustomerStatus.Active,
    firstName = "Peter",
    lastName = "Parker",
    language = Language.en
)
