import React from "react";
import { UserContext } from "../context/UserContext.ts";
import { Users } from "../../../interface/User/UserInterface.ts"
import { Input } from "@nextui-org/react";
import { useForm } from "react-hook-form";

const Fullname = () => {

  const { setUser } = React.useContext(UserContext);
  const { register, handleSubmit } = useForm<Users>();

  const addName = (name: string) => {
    setUser((prev) => {
      return { ...prev, fullName: name };
    })
  }
  const addUser = (user: Users) => {
    addName(user.fullName + "");
  }

  return (
    <form onSubmit={handleSubmit(addUser)}>
      <div >
        <label>Nombre</label>
        <Input type="text" {...register("fullName", { required: true })} />
      </div>
      <button > Click me</button>
    </form>
  );
};
export { Fullname };
