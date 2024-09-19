import { Bill } from "./UserBill";
import { UserState } from "./UserState";

export interface User {
  fullName?: string;
  email?: string;
  address?: string;
  password?: string;
  phoneNumber?: string;
  statate?: UserState
  bills?: Bill[];
}

