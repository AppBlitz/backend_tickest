import { useForm } from "react-hook-form";
import { User } from "../../interface/UserInterface.ts";
import { registerUser } from "./register.ts";

export function Register() {
  const { register, handleSubmit } = useForm<User>();
  return (
    <div>
      <form onSubmit={handleSubmit(registerUser)}>
        <div>
          <label>Nombre</label>
          <input type="text" {...register("fullName", { required: true })} />
        </div>
        <div>
          <label>email</label>
          <input type="text" {...register("email", { required: true })} />
        </div>
        <div>
          <label>address</label>
          <input type="text" {...register("address", { required: true })} />
        </div>
        <div>
          <label>password</label>
          <input type="text" {...register("password", { required: true })} />
        </div>
        <div>
          <label>phone number</label>
          <input type="text" {...register("phoneNumber", { required: true })} />
        </div>
        <button> click me</button>
      </form>
    </div>
  );
}
