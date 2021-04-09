import { ICity } from 'app/entities/city/city.model';
import { ICustomer } from 'app/entities/customer/customer.model';

export interface IAddress {
  id?: number;
  address?: string | null;
  location?: string | null;
  pincode?: number | null;
  city?: ICity | null;
  customer?: ICustomer | null;
}

export class Address implements IAddress {
  constructor(
    public id?: number,
    public address?: string | null,
    public location?: string | null,
    public pincode?: number | null,
    public city?: ICity | null,
    public customer?: ICustomer | null
  ) {}
}

export function getAddressIdentifier(address: IAddress): number | undefined {
  return address.id;
}
