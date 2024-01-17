import { Route } from "@angular/router";

export const appRoutes: Route[] = [
    {
        path:'validate',
        loadChildren: () => 
            import('src/app/validate/validate.routes').then((m) => m.validateRoutes),
    },
]