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
    if(request.headers.get("skip")){
      request.headers.delete("skip")
      return next.handle(request);
    }
    const email=this.dataService.email;
    const password=this.dataService.password;
    request = request.clone({
      setHeaders: {
        Authorization: 'Basic '+btoa(email+":"+password),
        'Access-Control-Allow-Origin':'*',
        'Content-Type':'application/json'
      }
    });
    console.log(request)

    return next.handle(request);
  }
}