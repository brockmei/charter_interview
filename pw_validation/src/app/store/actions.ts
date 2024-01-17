import { createAction, createActionGroup, props } from "@ngrx/store";
import { IUserPasswordRequest } from "../types/user-password-request.interface";
import { IUserPasswordResponseContent } from "../types/user-password-content.interface";
import { IUserPasswordResponse } from "../types/user-password-response.interface";
import { IUserValidationErrors } from "../types/user-validation-errors.interface";

export const validateActions = createActionGroup({ 
    source:'validate',
    events:{
        'Validate':props<{request: IUserPasswordRequest}>(),
        'Validation Success':props<{content: IUserPasswordResponseContent}>(),
        'Validation Failure':props<{errors: IUserValidationErrors}>(),
    }
})
export const validate = createAction('[Validate] Validate', props<{request:IUserPasswordRequest}>());
export const validatationSuccess = createAction('[Validate] Validatation Success', props<{content:IUserPasswordResponseContent}>());
export const validatationFailure = createAction('[Validate] Validatation Failure', props<{content:IUserValidationErrors}>());



