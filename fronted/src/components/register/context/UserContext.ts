import { createContext } from "react";
import { Users } from "../../../interface/User/UserInterface.ts";
interface users {
  User: Users,
  setUser: React.Dispatch<React.SetStateAction<Users>>
}

const userValue: users = {
  User: {
fullName:"",
    identificationNumber:"",
  },
  setUser: () => undefined
}

const UserContext = createContext(userValue);

export { UserContext };
