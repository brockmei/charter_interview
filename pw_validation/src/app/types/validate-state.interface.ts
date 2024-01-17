import { IUserValidationErrors } from "./user-validation-errors.interface";

export interface  IValidateState  {
    isSubmitting: boolean,
    validationErrors:IUserValidationErrors | null,
    isSuccessfulValidation:boolean,
}