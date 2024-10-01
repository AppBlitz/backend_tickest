import { Input } from '@nextui-org/react';
import { useForm } from 'react-hook-form';
import { api } from "../../api/api.ts"
import { Users } from '../../interface/User/UserInterface.ts';
function Activate(user: Users) {
  type Code = {
    codeRegister: string,
  }
  const { register, handleSubmit } = useForm<Code>();
  function updateUser(code: Code) {
    api({
      method: "put",
      url: "/update/register",
      data: {
        email: user.email,
        codeValidator: code.codeRegister,
        password: user.password,
      }
    })
      .catch((error) => {
        console.error(error);
      })
      .finally(() => {

      })
  }

  return (
    <div>
      <form onSubmit={handleSubmit(updateUser)}>
        <div>
          <Input type="text"  {...register("codeRegister")} />
        </div>
      </form>
    </div>
  )
}

export { Activate };
