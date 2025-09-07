import { createBrowserRouter } from "react-router-dom";
import App from "../App";
import NotFound from "../../components/pages/NotFound";


const Router = createBrowserRouter([
    {
        path: "/",
        element: <App />,
        errorElement: <NotFound />
    },
]);

export default Router;