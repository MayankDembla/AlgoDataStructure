import * as dayjs from 'dayjs';
import { IAddress } from 'app/entities/address/address.model';

export interface ICustomer {
  id?: number;
  name?: string | null;
  token?: string | null;
  phone?: string | null;
  sphone?: string | null;
  email?: string | null;
  active?: boolean | null;
  isFirstBooking?: boolean | null;
  timecreated?: dayjs.Dayjs | null;
  addresses?: IAddress[] | null;
}

export class Customer implements ICustomer {
  constructor(
    public id?: number,
    public name?: string | null,
    public token?: string | null,
    public phone?: string | null,
    public sphone?: string | null,
    public email?: string | null,
    public active?: boolean | null,
    public isFirstBooking?: boolean | null,
    public timecreated?: dayjs.Dayjs | null,
    public addresses?: IAddress[] | null
  ) {
    this.active = this.active ?? false;
    this.isFirstBooking = this.isFirstBooking ?? false;
  }
}

export function getCustomerIdentifier(customer: ICustomer): number | undefined {
  return customer.id;
}
