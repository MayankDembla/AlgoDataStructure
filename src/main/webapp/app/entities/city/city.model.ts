import { IAddress } from 'app/entities/address/address.model';

export interface ICity {
  id?: number;
  name?: string | null;
  address?: IAddress | null;
}

export class City implements ICity {
  constructor(public id?: number, public name?: string | null, public address?: IAddress | null) {}
}

export function getCityIdentifier(city: ICity): number | undefined {
  return city.id;
}
