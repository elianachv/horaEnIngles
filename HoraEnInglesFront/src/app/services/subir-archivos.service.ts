import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient, HttpRequest, HttpEvent,HttpParams} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SubirArchivosService {

  baseUrl = environment.baseUrl;

  constructor(private http: HttpClient) { }

  consultarHoraEnIngles(file: File): Observable<HttpEvent<any>>{
    const formData: FormData = new FormData();
    formData.append('files', file);
   
    const req = new HttpRequest('POST', `${this.baseUrl}/consultarHoraEnIngles`, formData, {
      reportProgress: true,
      responseType: 'json'
    });
    return this.http.request(req);
  }



}
