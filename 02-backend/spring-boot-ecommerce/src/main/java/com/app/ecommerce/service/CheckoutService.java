package com.app.ecommerce.service;

import com.app.ecommerce.dto.PaymentInfo;
import com.app.ecommerce.dto.Purchase;
import com.app.ecommerce.dto.PurchaseResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);

    PaymentIntent createPaymentIntent(PaymentInfo paymentInfo) throws StripeException;

}
