package com.a473201.hanssen.lab1;


class Store {
    // Values to manage between activities.
    String T1_value, T2_value, T3_value, T4_value;


    private static final Store ourInstance = new Store();

    static Store getInstance() {
        return ourInstance;
    }

    // Initialize Store.
    private Store() {
        this.T1_value = this.T2_value = this.T3_value = this.T4_value = "";
    }
}
