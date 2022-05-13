import {EventEmitter, Injectable} from '@angular/core';
import Swal, { SweetAlertIcon } from 'sweetalert2';



@Injectable({
  providedIn: 'root'
})
export class SwalService {

  clickConfirm: EventEmitter<void>;
  clickCancel: EventEmitter<void>;

  constructor() {
  }

  alert(title): void {
    Swal.fire(title as SweetAlertIcon);
  }

  succes(title: string): void {
    Swal.fire({
      position: 'top-end',
      icon: 'success',
      title: title,
      showConfirmButton: false,
      timer: 1500
    })
  }

  danger(title: string): void {
    Swal.fire({
      position: 'top-end',
      icon: 'error',
      title: title,
      showConfirmButton: false,
      timer: 1500
    })
  }

  iniciarObservablesConfirm(): void {
    this.clickConfirm = new EventEmitter();
    this.clickCancel = new EventEmitter();
  }

  confirm(
    title = '',
    text = '',
    icon = 'warning',
    confirmButtonText = '',
    cancelButtonText = '',
    {
      clickConfirm = () => {
      }, clickCancel = () => {
    }
    } = {},
    showCancelButton = true
  ): Promise<any> {
    this.iniciarObservablesConfirm();
    return Swal.fire({
      title,
      text,
      icon: icon as SweetAlertIcon,
      showCancelButton,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText,
      cancelButtonText
    }).then(result => {
      if (result.value) {
        this.clickConfirm.subscribe(() => clickConfirm());
        this.clickConfirm.emit();
        this.clickConfirm.unsubscribe();
      } else {
        this.clickCancel.subscribe(() => clickCancel());
        this.clickCancel.emit();
        this.clickCancel.unsubscribe();
      }
    });
  }
}
