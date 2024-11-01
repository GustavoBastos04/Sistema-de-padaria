import {Table} from "react-bootstrap";
import ItemVenda from "../../components/ListItems/ItemVenda";

function HistoricoVendas() {
    return (
        <div>
            <Table className="striped bordered hover">
                <thead>
                    <tr>
                        <th>ID da venda</th>
                        <th>Valor</th>
                        <th>Data</th>
                    </tr>
                </thead>
                <tbody>
                    <ItemVenda id_venda="1234567890" valor="2,50" data="31/10/2024" />
                </tbody>
            </Table>
        </div>
    )
}

export default HistoricoVendas;