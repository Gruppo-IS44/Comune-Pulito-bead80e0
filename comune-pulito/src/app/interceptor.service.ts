import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DataService } from './data.service';
import { TagContentType } from '@angular/compiler';
import { sha256 } from 'js-sha256';

@Injectable()
export class InterceptorService implements HttpInterceptor {

  constructor(private dataService:DataService) {}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    console.log(request)
    request = request.clone({
      setHeaders: {
        Authorization: 'Basic '+btoa(this.dataService.email+":"+sha256(this.dataService.password)),
        'Access-Control-Allow-Origin': '*',
        'Content-Type': 'application/json'
      }
    });
    console.log(request)

    return next.handle(request);
  }
}