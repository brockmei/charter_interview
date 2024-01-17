import { createFeature, createReducer, on } from "@ngrx/store";
import { IValidateState } from "../types/validate-state.interface";
import { validateActions } from "./actions";

const initialState: IValidateState = {
    isSubmitting: false,
    validationErrors:null,
    isSuccessfulValidation:false,
}

const validateFeature = createFeature({
    name:'validate',
    reducer: createReducer (
        initialState,
        on(validateActions.validate, (state) => ({...state, isSubmitting:true, isSuccessfulValidation:false, validationErrors:null})),
        on(validateActions.validationSuccess, (state) => ({...state, isSubmitting:false, isSuccessfulValidation:true})),
        on(validateActions.validationFailure, (state, action) => ({...state, isSubmitting:false, isSuccessfulValidation:false, validationErrors:action.errors})),
    )
})

export const {
    name:validateFeatureKey,
    reducer:validateReducer,
    selectIsSubmitting,
    selectIsSuccessfulValidation,
    selectValidationErrors,
} = validateFeature

