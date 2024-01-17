import { inject } from "@angular/core";
import { validateActions } from "./actions";
import { Actions, createEffect, ofType } from "@ngrx/effects";

import { catchError, map, of, switchMap } from "rxjs";
import { HttpErrorResponse } from "@angular/common/http";
import { ValidationService } from "../validate/services/validation.service";
import { IUserPasswordResponseContent } from "../types/user-password-content.interface";
import { IUserPasswordResponse } from "../types/user-password-response.interface";

export const validateEffects = createEffect((
    actions$ = inject(Actions),
    validationService = inject(ValidationService),

) => {
    return actions$.pipe(
        ofType(validateActions.validate),
        switchMap(({request}) => {
            return validationService.validate(request).pipe(
                map((content:IUserPasswordResponseContent) => {

                    return validateActions.validationSuccess({content})
                }),
                catchError((errorResponse: HttpErrorResponse) => {
                    console.log("validation errors are " + errorResponse.error);
                    console.log(JSON.stringify(errorResponse.error))

                    return of(validateActions.validationFailure({errors: errorResponse.error.results}))
                })
            )
        })
    ) 
},
{functional: true})

