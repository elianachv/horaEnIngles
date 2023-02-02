import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SubirArchivosComponent } from './components/subir-archivos/subir-archivos.component';

const routes: Routes = [
  { path: 'subir-archivo', component: SubirArchivosComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }