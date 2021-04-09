import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { finalize } from 'rxjs/operators';

import * as dayjs from 'dayjs';
import { DATE_TIME_FORMAT } from 'app/config/input.constants';

import { ICustomer, Customer } from '../customer.model';
import { CustomerService } from '../service/customer.service';

@Component({
  selector: 'jhi-customer-update',
  templateUrl: './customer-update.component.html',
})
export class CustomerUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    name: [],
    token: [],
    phone: [],
    sphone: [],
    email: [],
    active: [],
    isFirstBooking: [],
    timecreated: [],
  });

  constructor(protected customerService: CustomerService, protected activatedRoute: ActivatedRoute, protected fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ customer }) => {
      if (customer.id === undefined) {
        const today = dayjs().startOf('day');
        customer.timecreated = today;
      }

      this.updateForm(customer);
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const customer = this.createFromForm();
    if (customer.id !== undefined) {
      this.subscribeToSaveResponse(this.customerService.update(customer));
    } else {
      this.subscribeToSaveResponse(this.customerService.create(customer));
    }
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<ICustomer>>): void {
    result.pipe(finalize(() => this.onSaveFinalize())).subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.previousState();
  }

  protected onSaveError(): void {
    // Api for inheritance.
  }

  protected onSaveFinalize(): void {
    this.isSaving = false;
  }

  protected updateForm(customer: ICustomer): void {
    this.editForm.patchValue({
      id: customer.id,
      name: customer.name,
      token: customer.token,
      phone: customer.phone,
      sphone: customer.sphone,
      email: customer.email,
      active: customer.active,
      isFirstBooking: customer.isFirstBooking,
      timecreated: customer.timecreated ? customer.timecreated.format(DATE_TIME_FORMAT) : null,
    });
  }

  protected createFromForm(): ICustomer {
    return {
      ...new Customer(),
      id: this.editForm.get(['id'])!.value,
      name: this.editForm.get(['name'])!.value,
      token: this.editForm.get(['token'])!.value,
      phone: this.editForm.get(['phone'])!.value,
      sphone: this.editForm.get(['sphone'])!.value,
      email: this.editForm.get(['email'])!.value,
      active: this.editForm.get(['active'])!.value,
      isFirstBooking: this.editForm.get(['isFirstBooking'])!.value,
      timecreated: this.editForm.get(['timecreated'])!.value
        ? dayjs(this.editForm.get(['timecreated'])!.value, DATE_TIME_FORMAT)
        : undefined,
    };
  }
}
