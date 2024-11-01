import {Table} from "react-bootstrap";
import ItemEstoque from "../components/ListItems/ItemEstoque.jsx";

function Estoque() {
    return (
        <div>
            <Table className="striped bordered hover">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Valor</th>
                        <th>Quantidade</th>
                    </tr>
                </thead>
                <tbody>
                    <ItemEstoque nome="Pão" valor="2,50" quantidade="2" />
                    <ItemEstoque nome="Coca-Cola" valor="5,00" quantidade="10" />
                </tbody>
            </Table>
        </div>
    )
}

export default Estoque