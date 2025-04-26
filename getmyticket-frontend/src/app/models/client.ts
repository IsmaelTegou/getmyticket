import {User} from './user';

export interface Client {
  numCNI: string;
  firstName: string;
  lastName: string;
  phone: string;
  email: string;
  password: string;
}
