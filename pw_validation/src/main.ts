import { bootstrapApplication } from "@angular/platform-browser";
import { AppComponent } from "./app/app.component";
import { provideRouter } from "@angular/router";
import { appRoutes } from "./app/app.routes";
import { provideState, provideStore } from "@ngrx/store";
import { provideEffects } from "@ngrx/effects";
import { provideHttpClient } from "@angular/common/http";
import * as validateEffects from "./app/store/effects";
import { provideStoreDevtools } from "@ngrx/store-devtools";


import { validateFeatureKey, validateReducer } from "./app/store/reducer";

bootstrapApplication(AppComponent, {
  providers: [
    provideRouter(appRoutes),
    provideStore(),
    provideState(validateFeatureKey, validateReducer),
    provideEffects(validateEffects),
    provideHttpClient(),
    provideStoreDevtools(
      {
          maxAge:25,
          logOnly: true,
          autoPause:true,
          trace: false,
          traceLimit: 75,
      }
  ),
  ]
})

