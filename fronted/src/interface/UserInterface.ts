export interface User {
  fullName?: string;
  email?: string;
  address?: string;
  password?: string;
  phoneNumber?: string;
  statate?: string;
  bills?: Bill[];
}

interface Bill {
  nameUser?: string;
}
