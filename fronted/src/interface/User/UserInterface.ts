import { Bill } from "./UserBill";

export type Users = {
  fullName?: string;
  email?: string;
  address?: string;
  password?: string;
  phoneNumber?: string;
  identificationNumber: string,
  bills?: Bill[];
};
