package com.globant;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

public class PurchaseProductTest {
    private static final Logger logger = LogManager.getLogger(PurchaseProductTest.class);

    @BeforeClass
    public void setup() {
        // Perform setup actions (e.g., open a browser, navigate to the website)
    }



    @Test
    public void purchaseProduct() {
        // Print actions for purchasing a product
        // Example: Select a random product, add it to the cart, provide personal data, and check the "Thank you" page.
        logger.info("Hello");
    }

    @AfterTest
    public void teardown() {
        // Perform cleanup actions (e.g., close the browser)
    }
}