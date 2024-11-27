import { Component, OnInit } from '@angular/core';
import { SubirArchivosService } from '../../services/subir-archivos.service';
import { Observable } from 'rxjs';
import { HttpEventType, HttpResponse } from '@angular/common/http';
@Component({
  selector: 'app-subir-archivos',
  templateUrl: './subir-archivos.component.html',
  styleUrls: ['./subir-archivos.component.css'],
})
export class SubirArchivosComponent {
  archivo: File | undefined;
  progreso = 0;
  respuesta: Array<any> | undefined;
  error = '';
  nombreArchivo = '';

  constructor(private subirArchivosService: SubirArchivosService) {}

  seleccionarArchivo(event: any) {
    this.nombreArchivo = event.target.files[0].name;
    this.archivo = event.target.files[0];
    this.archivo?.size;
  }

  subirArchivo(file: File) {
    this.subirArchivosService.consultarHoraEnIngles(file).subscribe({
      next: (event) => {
        if (event.type === HttpEventType.UploadProgress) {
          this.progreso = Math.round(
            (100 * event.loaded) / (event.total ? event.total : 100)
          );
        } else if (event instanceof HttpResponse) {
          this.respuesta = event.body;
        }
      },
      error: (err) => {
        console.log(err)
        this.progreso = 0;
        this.error = err.error.descripcion
      },
    });
  }

  reset(){
    this.archivo = undefined;
    this.nombreArchivo = '';
    this.error = '';
    this.respuesta = undefined;
  }
}
