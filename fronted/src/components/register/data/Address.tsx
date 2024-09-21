import { Users } from "../../../interface/User/UserInterface.ts"
import { useForm } from "react-hook-form";
import { Input } from "@nextui-org/react";
import { UserContext } from "../context/UserContext";
import React from "react";

const Address = () => {

  const { User, setUser } = React.useContext(UserContext);
  const { register, handleSubmit } = useForm<Users>();

  const addName = (address: string) => {
    setUser((prev) => {
      return { ...prev, address: address };
    })
  }
  const addUser = (user: Users) => {
    addName(user.address + "");
  }
  function us() {
    console.log(User);
  }
  return <div>
    <form onSubmit={handleSubmit(addUser)}>
      <div>
        <label>Dirección</label>
        <Input type="text" {...register("address", { required: true })} />
      </div>
      <button onClick={us}>Click me</button>
    </form>
  </div>;
};
export { Address };
