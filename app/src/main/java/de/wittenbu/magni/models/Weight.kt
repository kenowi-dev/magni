package de.wittenbu.magni.models

enum class WeightBase {
    ONE_REP_MAX_PERCENT,
    BODY_WEIGHT_PERCENT,
    KG_LBS
}

class Weight(val weightType: WeightType, val amount: Int) {

}
