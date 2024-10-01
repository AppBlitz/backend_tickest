
import { useRouteError } from "react-router-dom"
function PagineError() {
  const error = useRouteError();
  console.log(error);
  return (<div id="error-page">
    <h1> ops</h1>
    <p> Sorry, an unexpected error has occurred.</p>
  </div>)
}
export { PagineError };
