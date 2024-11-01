import {Table} from "react-bootstrap";
import ItemProduto from "../components/ListItems/ItemProduto.jsx";

function Produtos() {
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
                    <ItemProduto nome="Pão" valor="2,50" quantidade="2" />
                </tbody>
            </Table>
        </div>
    )
}

export default Produtos